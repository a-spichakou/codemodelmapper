
package test.mapper;

import github.compile.mapper.source.InnerTargetClass1;
import github.compile.mapper.source.InnerTargetClass2;
import github.compile.mapper.source.SourceObject;
import github.compile.mapper.source.TargetObject;

public class GenerateMapperDefaultValue {

    public SourceObject source;
    public TargetObject target;

    public void map() {
        map_target();
    }

    public String getValue() {
        return "defaultValue";
    }

    public void map_target() {
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
        value = getValue();
        decl = ((String) value);
        innertargetclass21 .setTg3(decl);
    }

}
