package smartcampus.services.esse3;

import it.sayservice.platform.domain.expressions.Type;
import it.sayservice.platform.domain.model.interfaces.Constants.Visibility;
import it.sayservice.platform.domain.model.interfaces.DomainTypeInterface;
import it.sayservice.platform.domain.model.interfaces.Operation;
import it.sayservice.platform.domain.model.interfaces.Port;
import it.sayservice.platform.domain.model.interfaces.RelDef;
import it.sayservice.platform.domain.model.interfaces.VarDef;
import it.sayservice.platform.domain.model.interfaces.impl.DomainTypeInterfaceImpl;
import it.sayservice.platform.domain.model.interfaces.impl.VarDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.RelDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.OperationImpl;
import it.sayservice.platform.domain.model.interfaces.impl.ArgumentDefImpl;
import it.sayservice.platform.domain.model.interfaces.impl.PortImpl;

import java.util.ArrayList;
import java.util.Collection;

public class  StudentExamsInterface extends DomainTypeInterfaceImpl {

    private static DomainTypeInterface intf = null;
    public static DomainTypeInterface getInstance() {
        if (intf==null) intf = new StudentExamsInterface();
        return intf;
    }

    @Override
    public boolean isType() {
        return  true; 
    }

    @Override
    public String getPackage() {
        return "smartcampus.services.esse3";
    }

    @Override
    public String getName() {
        return "StudentExams";
    }

    private static Collection<VarDef> varDefs = new ArrayList<VarDef>();
    static {
        VarDefImpl vd = null;
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("examData");
        vd.setType(new Type(smartcampus.services.esse3.data.ExamData .class, true));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("idAda");
        vd.setType(new Type(java.lang.String .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("userId");
        vd.setType(new Type(java.lang.String .class, false));
        varDefs.add(vd);
    }
    
    @Override
    public Collection<VarDef> getVarDefinitions() {
        return varDefs;
    }

    private static Collection<RelDef> relDefs = new ArrayList<RelDef>();
    static {
        RelDefImpl rd = null;
    }    

    @Override
    public Collection<RelDef> getRelDefinitions() {
        return relDefs;
    }

    private static Collection<DomainTypeInterface> extended = new ArrayList<DomainTypeInterface>();
    static {
        DomainTypeInterface e = null;
    }    

    @Override
    public Collection<DomainTypeInterface> getDirectExtendedTypes() {
        return extended;
    }

    private static Collection<Operation> operations = new ArrayList<Operation>();
    static {
        OperationImpl o = null;
        ArgumentDefImpl a = null;

        o = new OperationImpl();
        o.setName("getStudentExams");
        o.setReturn(new Type(smartcampus.services.esse3.data.ExamData .class, true));
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("idAda");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("subscribeStudentExams");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("idAda");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        operations.add(o);
    }    
    @Override
    public Collection<Operation> getOperations() {
        return operations;
    }

    private static Collection<Port> ports = new ArrayList<Port>();
    static {
        PortImpl p = null;
        ArgumentDefImpl a = null;
    }
    
    @Override
    public Collection<Port> getPorts() {
        return ports;
    }

}


