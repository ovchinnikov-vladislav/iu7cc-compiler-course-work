package ic7cc.ovchinnikov.compiler.ast.node;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import ic7cc.ovchinnikov.compiler.ast.Visitor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VariableNode extends Variable {

    @JacksonXmlProperty(isAttribute = true)
    private String var;

    public VariableNode(String var) {
        this.var = var;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void childrenAccept(Visitor visitor) {
    }

    @Override
    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    @Override
    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    @Override
    public String toString() {
        return var;
    }
}
