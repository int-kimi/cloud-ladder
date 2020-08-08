package ast.type;

import grammar.CLParserParser;

public class TypeName extends Type {
    public TypeName(CLParserParser.BasicTypeContext ctx) {
        super(ctx);
        name = ctx.getText();
    }

    @Override
    public String printNode() {
        return name;
    }
}