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
        return prependReversed(reversed, list);
      } else {
        return reverse(list.getTail(), k, kk - 1, n(list.getValue(), reversed));
      }
    }

    // kk == 0
    if (list.getTail() == NIL) {
      return n(list.getValue(), reversed);
    }
    return prepend(n(list.getValue(), reversed), reverse(list.getTail(), k, k, NIL));
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
