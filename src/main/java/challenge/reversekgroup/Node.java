package challenge.reversekgroup;

import java.util.Objects;

interface Node {

  Node NIL = new EmptyNode();

  static Node n(int value, Node tail) {
    return new ValueNode(value, tail);
  }

  default Node getTail() {
    throw new UnsupportedOperationException();
  }
  default int getValue() {
    throw new UnsupportedOperationException();
  }


  class ValueNode implements Node {

    public final int value;
    public final Node tail;

    public ValueNode(int value, Node tail) {
      this.value = value;
      this.tail = tail;
    }

    @Override
    public int getValue() {
      return value;
    }

    @Override
    public Node getTail() {
      return tail;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      ValueNode valueNode = (ValueNode) o;
      return value == valueNode.value &&
        tail.equals(valueNode.tail);
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, tail);
    }

    @Override
    public String toString() {
      return "{" +
         value +
        "," + tail +
        '}';
    }
  }

  class EmptyNode implements Node {
    @Override
    public String toString() {
      return "NIL";
    }
  }

}
