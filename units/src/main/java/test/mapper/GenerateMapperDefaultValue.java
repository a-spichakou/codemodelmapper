
package test.mapper;

import github.compile.mapper.test1.InnerTargetClass1;
import github.compile.mapper.test1.InnerTargetClass2;
import github.compile.mapper.test1.SourceObject;
import github.compile.mapper.test1.TargetObject;

public class GenerateMapperDefaultValue {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        mapTarget0();
    }

    public String getValue0() {
        return "defaultValue";
    }

    public void mapTarget0() {
        InnerTargetClass1 innertargetclass10;
        innertargetclass10 = target.getTarget3();
        if (innertargetclass10 == null) {
            innertargetclass10 = new InnerTargetClass1();
            target.setTarget3(innertargetclass10);
        }
        InnerTargetClass2 innertargetclass21;
        innertargetclass21 = innertargetclass10 .getTg2();
        if (innertargetclass21 == null) {
            innertargetclass21 = new InnerTargetClass2();
            innertargetclass10 .setTg2(innertargetclass21);
        }
        String value;
        String decl;
        value = getValue0();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}
