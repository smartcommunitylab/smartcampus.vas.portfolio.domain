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

public class  PortfolioInterface extends DomainTypeInterfaceImpl {

    private static DomainTypeInterface intf = null;
    public static DomainTypeInterface getInstance() {
        if (intf==null) intf = new PortfolioInterface();
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
        return "Portfolio";
    }

    private static Collection<VarDef> varDefs = new ArrayList<VarDef>();
    static {
        VarDefImpl vd = null;
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("entityId");
        vd.setType(new Type(java.lang.Long .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("highlightUserGeneratedData");
        vd.setType(new Type(java.lang.String .class, true));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("name");
        vd.setType(new Type(java.lang.String .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("showStudentInfo");
        vd.setType(new Type(java.lang.String .class, true));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("showUserGeneratedData");
        vd.setType(new Type(java.lang.String .class, true));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("tags");
        vd.setType(new Type(eu.trentorise.smartcampus.domain.semantic.Tag .class, true));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("timestamp");
        vd.setType(new Type(java.lang.Long .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("userId");
        vd.setType(new Type(java.lang.String .class, false));
        varDefs.add(vd);
        vd = new VarDefImpl();
        vd.setVisibility(Visibility.PUBLIC);
        vd.setName("userSocialId");
        vd.setType(new Type(java.lang.Long .class, false));
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
        o.setName("deletePortfolio");
        o.setVisibility(Visibility.PUBLIC);
        operations.add(o);

        o = new OperationImpl();
        o.setName("deleteSemanticData");
        o.setVisibility(Visibility.PUBLIC);
        operations.add(o);

        o = new OperationImpl();
        o.setName("updatePortfolio");
        o.setVisibility(Visibility.PUBLIC);
        a = new ArgumentDefImpl();
        a.setName("newName");
        a.setType(new Type(java.lang.String .class, false));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("newShowUserGeneratedData");
        a.setType(new Type(java.lang.String .class, true));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("newHighlightUserGeneratedData");
        a.setType(new Type(java.lang.String .class, true));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("newShowStudentInfo");
        a.setType(new Type(java.lang.String .class, true));
        o.addArgument(a);
        a = new ArgumentDefImpl();
        a.setName("newTags");
        a.setType(new Type(eu.trentorise.smartcampus.domain.semantic.Tag .class, true));
        o.addArgument(a);
        operations.add(o);

        o = new OperationImpl();
        o.setName("updateSemanticData");
        o.setVisibility(Visibility.PUBLIC);
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


