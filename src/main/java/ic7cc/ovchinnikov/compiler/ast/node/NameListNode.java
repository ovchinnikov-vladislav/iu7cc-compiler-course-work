package ic7cc.ovchinnikov.compiler.ast.node;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ic7cc.ovchinnikov.compiler.ast.impl.ASTNode;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
public class NameListNode extends ASTNode {

    private final List<NameNode> nameNodeList;
    @JsonIgnore
    private ASTNode parent;

    public NameListNode() {
        nameNodeList = new LinkedList<>();
    }

    public NameListNode(NameNode anItem) {
        this();
        append(anItem);
    }

    @Override
    public ASTNode getParent() {
        return parent;
    }

    @Override
    public void setParent(ASTNode parent) {
        this.parent = parent;
    }

    public NameListNode append(NameNode anItem) {
        if (anItem == null)
            return this;
        anItem.setParent(this);
        nameNodeList.add(anItem);
        return this;
    }

    public List<NameNode> elements() {
        return Collections.unmodifiableList(nameNodeList);
    }

    public NameNode getName(int index) {
        return nameNodeList.get(index);
    }

    public void setName(int index, NameNode item) {
        item.setParent(this);
        nameNodeList.set(index, item);
    }

    public void addName(int index, NameNode item) {
        item.setParent(this);
        nameNodeList.add(index, item);
    }

    public void removeName(int index) {
        nameNodeList.remove(index);
    }

    public int size() {
        return nameNodeList.size();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return nameNodeList.isEmpty();
    }

    public boolean contains(NameNode item) {
        for (NameNode nameNode : nameNodeList)
            if (item.equals(nameNode))
                return true;
        return false;
    }

    public int indexOf(NameNode item) {
        return nameNodeList.indexOf(item);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (NameNode nameNode : nameNodeList) {
            builder.append(nameNode).append(",");
        }
        String names = builder.toString();
        if (!names.trim().isEmpty() && names.charAt(names.length() - 1) == ',')
            names = names.substring(0, names.length() - 1);

        return names;
    }
}
