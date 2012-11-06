
package github.compile.mapper.test;

import github.compile.example.Source;

public class MapSource2Target {

    public Source source;
    public Target target;

    public void map() {
        mapTarget0();
        mapTarget1();
    }

    public String getValue0() {
        return "dafultValue";
    }

    public void mapTarget0() {
        String value;
        String decl;
        value = getValue0();
        decl = ((String) value);
        target.setLevel0String(decl);
    }

    public Object getValue1() {
        Integer integer0;
        integer0 = ((Integer) source.getLevel0primitive());
        if ((integer0==null)) {
            return null;
        }
        return integer0;
    }

    public void mapTarget1() {
        Object value;
        Integer decl;
        value = getValue1();
        decl = ((Integer) value);
        target.setLevel0primitive(decl);
    }

}
