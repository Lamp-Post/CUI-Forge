package cui.config;

import java.util.List;

import cui.vendor.org.yaml.snakeyaml.introspector.Property;
import cui.vendor.org.yaml.snakeyaml.nodes.CollectionNode;
import cui.vendor.org.yaml.snakeyaml.nodes.MappingNode;
import cui.vendor.org.yaml.snakeyaml.nodes.Node;
import cui.vendor.org.yaml.snakeyaml.nodes.NodeTuple;
import cui.vendor.org.yaml.snakeyaml.nodes.SequenceNode;
import cui.vendor.org.yaml.snakeyaml.nodes.Tag;
import cui.vendor.org.yaml.snakeyaml.representer.Represent;
import cui.vendor.org.yaml.snakeyaml.representer.Representer;

public class EmptyNullRepresenter extends Representer
{
  public EmptyNullRepresenter()
  {
    this.nullRepresenter = new EmptyRepresentNull();
  }

  protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag)
  {
    NodeTuple tuple = super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
    Node valueNode = tuple.getValueNode();
    if ((valueNode instanceof CollectionNode))
    {
      if (Tag.SEQ.equals(valueNode.getTag())) {
        SequenceNode seq = (SequenceNode)valueNode;
        if (seq.getValue().isEmpty()) {
          return null;
        }
      }
      if (Tag.MAP.equals(valueNode.getTag())) {
        MappingNode seq = (MappingNode)valueNode;
        if (seq.getValue().isEmpty()) {
          return null;
        }
      }
    }
    return tuple;
  }

  protected class EmptyRepresentNull
    implements Represent
  {
    protected EmptyRepresentNull()
    {
    }

    public Node representData(Object data)
    {
      return EmptyNullRepresenter.this.representScalar(Tag.NULL, "");
    }
  }
}