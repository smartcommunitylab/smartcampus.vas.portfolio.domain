package smartcampus.services.esse3;

import it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException;
import it.sayservice.platform.core.domain.DomainConst.DOMAIN_OBJECT_EVENT_TYPE;
import it.sayservice.platform.core.domain.DomainRelationTarget;
import it.sayservice.platform.core.domain.bundle.DomainEvent;
import it.sayservice.platform.core.domain.ext.AbstractDOEngineImpl;
import it.sayservice.platform.core.domain.ext.ActionInvoke;
import it.sayservice.platform.core.domain.ext.DomainObjectWrapper;
import it.sayservice.platform.core.domain.ext.LanguageHelper;
import it.sayservice.platform.core.domain.ext.Tuple;
import it.sayservice.platform.core.domain.rules.DomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainSubscriptionRule;
import it.sayservice.platform.core.domain.rules.EvaluableDomainOperation;
import it.sayservice.platform.core.domain.rules.DomainEventDescriptor;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.ArrayList;
import java.util.HashMap;

import com.mongodb.DBObject;
import com.mongodb.QueryBuilder;

public class UserProducedDataFactoryDOEngine extends AbstractDOEngineImpl {

    public UserProducedDataFactoryDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "createUserProducedData",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAKc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250ABZjcmVhdGVVc2VyUHJvZHVjZWREYXRhdAAKYWN0aW9uTmFtZXQAFmNyZWF0ZVVzZXJQcm9kdWNlZERhdGF0AAR0eXBldAAFTG9jYWx4eA=="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("createUserProducedData".equals(actionName)) {
            return createUserProducedData(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object createUserProducedData(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String newUserId = (java.lang.String) tuple.get("newUserId");
java.lang.String newCategory = (java.lang.String) tuple.get("newCategory");
java.lang.String newType = (java.lang.String) tuple.get("newType");
java.lang.String newTitle = (java.lang.String) tuple.get("newTitle");
java.lang.String newSubtitle = (java.lang.String) tuple.get("newSubtitle");
java.lang.String newContent = (java.lang.String) tuple.get("newContent");
{
{
Tuple body = new Tuple();
 body.put("category",newCategory);
 body.put("content",newContent);
 body.put("subtitle",newSubtitle);
 body.put("timestamp",java.lang.System.currentTimeMillis());
 body.put("title",newTitle);
 body.put("type",newType);
 body.put("userId",newUserId);
getDomainObjectHandler().create(null, "smartcampus.services.esse3.UserProducedData", body, evts, ops, securityToken, bundleId);}
}
return null;
}

    }
    
    
    
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        return null;
    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
        ;    
    }

    @Override
    public String getType() {
        return "smartcampus.services.esse3.UserProducedDataFactory";
    }

    @Override
    public boolean isStatic() {
        return !false;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return smartcampus.services.esse3 .UserProducedDataFactoryInterface .getInstance();
    }
    

    public List<DomainSubscriptionRule> findSubscriptionRules(DomainEvent event, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> result = new ArrayList<DomainSubscriptionRule>();
        List<DomainSubscriptionRule> tmp = null;
        return result;
    }
    
    public Collection<DomainEventDescriptor> getEventsToQuery() {
        List<DomainEventDescriptor> result = new ArrayList<DomainEventDescriptor>();
        return result;
    }
    
}


