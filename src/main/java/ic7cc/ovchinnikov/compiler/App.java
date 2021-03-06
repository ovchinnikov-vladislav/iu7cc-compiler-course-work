/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ic7cc.ovchinnikov.compiler;

import ic7cc.ovchinnikov.compiler.ast.ParseTreeBuilder;
import ic7cc.ovchinnikov.compiler.ast.node.*;
import ic7cc.ovchinnikov.compiler.lexer.Lexer;
import ic7cc.ovchinnikov.compiler.parser.Parser;
import ic7cc.ovchinnikov.compiler.semantic.ExpressionDataTypeTableBuilder;
import ic7cc.ovchinnikov.compiler.util.XmlSerializer;

import java.io.File;
import java.io.FileReader;

public class App {

    public static void main(String[] args) throws Exception {
        ParseTreeBuilder parseTreeBuilder = new ParseTreeBuilder();
        BlockNode blockNode = parseTreeBuilder.builder("lua/testlocal.lua", "result/xml/testlocal.xml");

        ExpressionDataTypeTableBuilder builder = new ExpressionDataTypeTableBuilder();
        builder.analyze(blockNode);
    }
}
