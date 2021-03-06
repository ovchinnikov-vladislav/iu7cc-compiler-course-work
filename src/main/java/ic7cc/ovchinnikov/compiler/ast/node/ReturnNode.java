package ic7cc.ovchinnikov.compiler.ast.node;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ReturnNode extends ReturnStatement {

    @JacksonXmlProperty(localName = "ExpList")
    private ExpressionListNode expressionListNode;

    public ReturnNode(ExpressionListNode expressionListNode) {
        this.expressionListNode = expressionListNode;
        if (expressionListNode != null) expressionListNode.setParent(this);
    }

    @Override
    public String toString() {
        return "return " + expressionListNode;
    }
}
