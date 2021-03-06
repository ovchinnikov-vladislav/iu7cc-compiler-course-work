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
public class VariableListNode extends ASTNode {

    private final List<Variable> variableList;
    @JsonIgnore
    private ASTNode parent;

    public VariableListNode() {
        variableList = new LinkedList<>();
    }

    public VariableListNode(Variable anItem) {
        this();
        append(anItem);
    }

    public VariableListNode append(Variable anItem) {
        if (anItem == null)
            return this;
        anItem.setParent(this);
        variableList.add(anItem);
        return this;
    }

    public List<Variable> elements() {
        return Collections.unmodifiableList(variableList);
    }

    public Variable getVar(int index) {
        return variableList.get(index);
    }

    public void setVar(int index, Variable item) {
        item.setParent(this);
        variableList.set(index, item);
    }

    public void addVar(int index, Variable item) {
        item.setParent(this);
        variableList.add(index, item);
    }

    public void removeVar(int index) {
        variableList.remove(index);
    }

    public int size() {
        return variableList.size();
    }

    @JsonIgnore
    public boolean isEmpty() {
        return variableList.isEmpty();
    }

    public boolean contains(Variable item) {
        for (Variable variable : variableList)
            if (item.equals(variable))
                return true;
        return false;
    }

    public int indexOf(Variable item) {
        return variableList.indexOf(item);
    }

    @Override
    public ASTNode getParent() {
        return parent;
    }

    @Override
    public void setParent(ASTNode parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Variable var : variableList) {
            builder.append(var).append(",");
        }
        String args = builder.toString();
        if (!args.trim().isEmpty() && args.charAt(args.length() - 1) == ',')
            args = args.substring(0, args.length() - 1);

        return args;
    }
}
