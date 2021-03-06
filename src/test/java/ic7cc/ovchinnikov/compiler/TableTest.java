package ic7cc.ovchinnikov.compiler;

import ic7cc.ovchinnikov.compiler.ast.node.BlockNode;
import ic7cc.ovchinnikov.compiler.lexer.Lexer;
import ic7cc.ovchinnikov.compiler.parser.Parser;
import ic7cc.ovchinnikov.compiler.semantic.ExpressionDataTypeTableBuilder;
import ic7cc.ovchinnikov.compiler.util.XmlSerializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.HashMap;

public class TableTest {

    private XmlSerializer xmlSerializer;

    @Before
    public void init() {
        xmlSerializer = new XmlSerializer();
    }

    @Test
    public void argsTableTest() throws Exception {
        File file = Path.of("lua/tables/args_tableconstructor.lua").toFile();

        Parser parser = new Parser(new Lexer(new FileReader(file)));
        BlockNode block = (BlockNode) parser.parse().value;

        xmlSerializer.save(block, Path.of("result/tables/xml/args_tableconstructor.xml").toFile());

        HashMap<String, Object> result = xmlSerializer.read(Path.of("result/tables/xml/args_tableconstructor.xml").toFile());
        HashMap<String, Object> expected = xmlSerializer.read(Path.of("expected/tables/xml/expected_args_tableconstructor.xml").toFile());

        Assert.assertEquals(expected, result);
    }

    @Test
    public void expTableTest() throws Exception {
        File file = Path.of("lua/tables/exp_tableconstructor.lua").toFile();

        Parser parser = new Parser(new Lexer(new FileReader(file)));
        BlockNode block = (BlockNode) parser.parse().value;

        xmlSerializer.save(block, Path.of("result/tables/xml/exp_tableconstructor.xml").toFile());

        HashMap<String, Object> result = xmlSerializer.read(Path.of("result/tables/xml/exp_tableconstructor.xml").toFile());
        HashMap<String, Object> expected = xmlSerializer.read(Path.of("expected/tables/xml/expected_exp_tableconstructor.xml").toFile());

        Assert.assertEquals(expected, result);

        ExpressionDataTypeTableBuilder builder = new ExpressionDataTypeTableBuilder();
        builder.analyze(block);

        Assert.assertEquals(ExpressionDataTypeTableBuilder.Type.TABLE, builder.getTypeMap().get("a"));
    }

    @Test
    public void expEmptyTableTest() throws Exception {
        File file = Path.of("lua/tables/exp_tableconstructor_empty.lua").toFile();

        Parser parser = new Parser(new Lexer(new FileReader(file)));
        BlockNode block = (BlockNode) parser.parse().value;

        xmlSerializer.save(block, Path.of("result/tables/xml/exp_tableconstructor_empty.xml").toFile());

        HashMap<String, Object> result = xmlSerializer.read(Path.of("result/tables/xml/exp_tableconstructor_empty.xml").toFile());
        HashMap<String, Object> expected = xmlSerializer.read(Path.of("expected/tables/xml/expected_exp_tableconstructor_empty.xml").toFile());

        Assert.assertEquals(expected, result);

        ExpressionDataTypeTableBuilder builder = new ExpressionDataTypeTableBuilder();
        builder.analyze(block);

        Assert.assertEquals(ExpressionDataTypeTableBuilder.Type.TABLE, builder.getTypeMap().get("a"));
    }

    @Test
    public void expListTableTest() throws Exception {
        File file = Path.of("lua/tables/explist_tableconstructor.lua").toFile();

        Parser parser = new Parser(new Lexer(new FileReader(file)));
        BlockNode block = (BlockNode) parser.parse().value;

        xmlSerializer.save(block, Path.of("result/tables/xml/explist_tableconstructor.xml").toFile());

        HashMap<String, Object> result = xmlSerializer.read(Path.of("result/tables/xml/explist_tableconstructor.xml").toFile());
        HashMap<String, Object> expected = xmlSerializer.read(Path.of("expected/tables/xml/expected_explist_tableconstructor.xml").toFile());

        Assert.assertEquals(expected, result);

        ExpressionDataTypeTableBuilder builder = new ExpressionDataTypeTableBuilder();
        builder.analyze(block);

        Assert.assertEquals(ExpressionDataTypeTableBuilder.Type.TABLE, builder.getTypeMap().get("a"));
    }

    @Test
    public void tablesSimpleTest() throws Exception {
        File file = Path.of("lua/tables/tables_simple.lua").toFile();

        Parser parser = new Parser(new Lexer(new FileReader(file)));
        BlockNode block = (BlockNode) parser.parse().value;

        xmlSerializer.save(block, Path.of("result/tables/xml/tables_simple.xml").toFile());

        HashMap<String, Object> result = xmlSerializer.read(Path.of("result/tables/xml/tables_simple.xml").toFile());
        HashMap<String, Object> expected = xmlSerializer.read(Path.of("expected/tables/xml/expected_tables_simple.xml").toFile());

        Assert.assertEquals(expected, result);
    }
}
