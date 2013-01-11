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

public class PortfolioFactoryDOEngine extends AbstractDOEngineImpl {

    public PortfolioFactoryDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "createPortfolio",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
        extensions.put("it.sayservice.platform.core.domain.actions.InvokeOperation",decodeExtension("rO0ABXNyABNqYXZhLnV0aWwuQXJyYXlMaXN0eIHSHZnHYZ0DAAFJAARzaXpleHAAAAABdwQAAAAKc3IAEWphdmEudXRpbC5IYXNoTWFwBQfawcMWYNEDAAJGAApsb2FkRmFjdG9ySQAJdGhyZXNob2xkeHA/QAAAAAAADHcIAAAAEAAAAAN0AAlvcGVyYXRpb250AA9jcmVhdGVQb3J0Zm9saW90AAphY3Rpb25OYW1ldAAPY3JlYXRlUG9ydGZvbGlvdAAEdHlwZXQABUxvY2FseHg="));
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("createPortfolio".equals(actionName)) {
            return createPortfolio(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    private Object createPortfolio(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        {
java.lang.String newUserId = (java.lang.String) tuple.get("newUserId");
java.lang.Long newUserSocialId = (java.lang.Long) tuple.get("newUserSocialId");
java.lang.String newName = (java.lang.String) tuple.get("newName");
java.lang.Long newEntityId = (java.lang.Long) tuple.get("newEntityId");
{
List<DomainObjectWrapper> portfolio = _query___query_0(obj, securityToken, bundleId, newName, newUserId);
if ((portfolio == null) || (LanguageHelper.count(portfolio).equals(0))){
{
{
Tuple body = new Tuple();
 body.put("entityId",newEntityId);
 body.put("name",newName);
 body.put("timestamp",java.lang.System.currentTimeMillis());
 body.put("userId",newUserId);
 body.put("userSocialId",newUserSocialId);
getDomainObjectHandler().create(null, "smartcampus.services.esse3.Portfolio", body, evts, ops, securityToken, bundleId);}
}
}
}
return null;
}

    }
    
    
    
    private List<DomainObjectWrapper> _query___query_0(DomainObjectWrapper obj, String securityToken, String bundleId, java.lang.String newName, java.lang.String newUserId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (true) {
        queryList.add(QueryBuilder.start().and("content.userId").is(newUserId).and("content.name").is(newName).get());
    }
	try{
    	result = getDomainObjectHandler().query("smartcampus.services.esse3.Portfolio",QueryBuilder.start().or(queryList.toArray(new DBObject[]{})).get(), securityToken, bundleId);
	} catch(Exception e) {
    	result = getDomainObjectHandler().query("smartcampus.services.esse3.Portfolio", (DBObject)null, securityToken, bundleId);
    }
    for(DomainObjectWrapper w : result) {
        if (_matches___query_0(w, obj, bundleId, newName, newUserId)) {
            _final.add(w);
        }
    }
    return _final;
    }
    private boolean _matches___query_0(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId, java.lang.String newName, java.lang.String newUserId) throws DomainDataHandlerException {
        return (getDomainObjectHandler().getVar("userId",target,java.lang.String.class,bundleId).equals(newUserId)) && (getDomainObjectHandler().getVar("name",target,java.lang.String.class,bundleId).equals(newName));
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
        return "smartcampus.services.esse3.PortfolioFactory";
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
        return smartcampus.services.esse3 .PortfolioFactoryInterface .getInstance();
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


