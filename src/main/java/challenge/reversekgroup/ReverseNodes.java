package challenge.reversekgroup;

import static challenge.reversekgroup.Node.*;

public class ReverseNodes {

  public Node reverse(Node list, int k) {
    if (k == 0) {
      return list;
    }
    return reverse(list, k, k, NIL);

  }

  private Node reverse(Node list, int k, int kk, Node reversed) {
    if (kk > 1) {
      if (list.getTail() == NIL) {
        // list has 1 remaining value while there are more iterations to go left.
        // Thus the temp. reversed list needs to be put back in order to have a dangling sublist in original order.
        return prependReversed(reversed, list);
      } else {
        // deconstruct original list and prepend current value to reversed sublist
        return reverse(list.getTail(), k, kk - 1, n(list.getValue(), reversed));
      }
    }

    // kk == 0
    Node currentReversed = n(list.getValue(), reversed);
    if (list.getTail() == NIL) {
      // we found a complete sublist to revert while we reached the end of the original list.
      return currentReversed;
    }
    // prepend the reversed sublist to the remaining list that needs to be reversed.
    return prepend(currentReversed, reverse(list.getTail(), k, k, NIL));
  }

  private Node prependReversed(Node reversed, Node list) {
    if (reversed != NIL) {
      return prependReversed(reversed.getTail(), n(reversed.getValue(), list));
    }
    return list;
  }

  private Node prepend(Node list, Node tail) {
    if (list == NIL) {
      return tail;
    }
    return n(list.getValue(), prepend(list.getTail(), tail));
  }

}
