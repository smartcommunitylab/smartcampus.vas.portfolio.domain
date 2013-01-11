/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
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

public class StudentEntityDOEngine extends AbstractDOEngineImpl {

    public StudentEntityDOEngine() {
        super();
    }

    private static String[] actions = new String[]{
            "_process_onRelatedCreate_portfolio",
            "_process_onRelatedDelete_portfolio",
            "_process_onRelatedCreate_studentContainer",
            "_process_onRelatedDelete_studentContainer",
            "_process_onRelatedCreate_studentExams",
            "_process_onRelatedDelete_studentExams",
            "_process_onRelatedCreate_studentInfo",
            "_process_onRelatedDelete_studentInfo",
    };

    protected String[] getSortedActions() {
        return actions;
    }

    private static Map<String,Collection<java.io.Serializable>> extensions = new HashMap<String,Collection<java.io.Serializable>>();
    static {
    }

     public  Collection<java.io.Serializable> getExtensionValues(String property) {
        return extensions.get(property);
     }  
    
    protected Object executeAction(String actionName, DomainObjectWrapper obj, Tuple t, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        if ("_process_onRelatedCreate_portfolio".equals(actionName)) {
            return _process_onRelatedCreate_portfolio(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_portfolio".equals(actionName)) {
            return _process_onRelatedDelete_portfolio(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedCreate_studentContainer".equals(actionName)) {
            return _process_onRelatedCreate_studentContainer(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_studentContainer".equals(actionName)) {
            return _process_onRelatedDelete_studentContainer(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedCreate_studentExams".equals(actionName)) {
            return _process_onRelatedCreate_studentExams(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_studentExams".equals(actionName)) {
            return _process_onRelatedDelete_studentExams(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedCreate_studentInfo".equals(actionName)) {
            return _process_onRelatedCreate_studentInfo(t, obj, outEvents, ops, securityToken, bundleId);
        }
        if ("_process_onRelatedDelete_studentInfo".equals(actionName)) {
            return _process_onRelatedDelete_studentInfo(t, obj, outEvents, ops, securityToken, bundleId);
        }
        return null;
    }

    
    private Object _process_onRelatedCreate_portfolio(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("portfolio", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_portfolio(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("portfolio", obj, deleted, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedCreate_studentContainer(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("studentContainer", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_studentContainer(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("studentContainer", obj, deleted, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedCreate_studentExams(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("studentExams", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_studentExams(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("studentExams", obj, deleted, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedCreate_studentInfo(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper created = (DomainObjectWrapper) tuple.get("created");
       getDomainObjectHandler().addRelatedObject("studentInfo", obj, created, evts, bundleId);
       return null;

    }
    private Object _process_onRelatedDelete_studentInfo(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
               DomainObjectWrapper deleted = (DomainObjectWrapper) tuple.get("deleted");
       getDomainObjectHandler().removeRelatedObject("studentInfo", obj, deleted, evts, bundleId);
       return null;

    }
    
    
    private List<DomainObjectWrapper> _query_portfolio(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId))) {
        return getDomainObjectHandler().query("smartcampus.services.esse3.Portfolio", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_portfolio(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId));
    }
    private List<DomainObjectWrapper> _query_studentContainer(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId))) {
        return getDomainObjectHandler().query("smartcampus.services.esse3.StudentContainer", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_studentContainer(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId));
    }
    private List<DomainObjectWrapper> _query_studentExams(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId))) {
        return getDomainObjectHandler().query("smartcampus.services.esse3.StudentExams", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_studentExams(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId));
    }
    private List<DomainObjectWrapper> _query_studentInfo(DomainObjectWrapper obj, String securityToken, String bundleId) throws DomainDataHandlerException {
        List<DomainObjectWrapper> result = new ArrayList<DomainObjectWrapper>();
List<DomainObjectWrapper> _final = new ArrayList<DomainObjectWrapper>();
List<DBObject> queryList = new ArrayList<DBObject>();
    if (getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId))) {
        return getDomainObjectHandler().query("smartcampus.services.esse3.StudentInfo", null, securityToken, bundleId);
    }
    return java.util.Collections.emptyList();

    }
    private boolean _matches_studentInfo(DomainObjectWrapper target, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        return getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId).equals(getDomainObjectHandler().getVar("fiscalCode",obj,java.lang.String.class,bundleId));
    }
    
    public void handleObjectRelUpdate(String rName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
              || "fiscalCode".equals(rName)
            ) {
                getDomainObjectHandler().setRelation("portfolio", obj, _query_portfolio(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(rName)
            ) {
                getDomainObjectHandler().setRelation("studentContainer", obj, _query_studentContainer(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(rName)
            ) {
                getDomainObjectHandler().setRelation("studentExams", obj, _query_studentExams(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(rName)
            ) {
                getDomainObjectHandler().setRelation("studentInfo", obj, _query_studentInfo(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }
    public void handleObjectVarUpdate(String vName, DomainObjectWrapper obj, Set<DomainEvent> evts, String bundleId) throws DomainDataHandlerException {
            if (false
              || "fiscalCode".equals(vName)
            ) {
                getDomainObjectHandler().setRelation("portfolio", obj, _query_portfolio(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(vName)
            ) {
                getDomainObjectHandler().setRelation("studentContainer", obj, _query_studentContainer(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(vName)
            ) {
                getDomainObjectHandler().setRelation("studentExams", obj, _query_studentExams(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
            if (false
              || "fiscalCode".equals(vName)
            ) {
                getDomainObjectHandler().setRelation("studentInfo", obj, _query_studentInfo(obj, obj.getDomainObject().getSecurityToken(), bundleId), evts, bundleId);
            }
    }

    public void handleObjectCreate(DomainObjectWrapper obj, Set<DomainEvent> outEvents, Set<EvaluableDomainOperation> ops, String bundleId) throws DomainDataHandlerException {
            getDomainObjectHandler().setRelation("portfolio", obj, _query_portfolio(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
            getDomainObjectHandler().setRelation("studentContainer", obj, _query_studentContainer(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
            getDomainObjectHandler().setRelation("studentExams", obj, _query_studentExams(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
            getDomainObjectHandler().setRelation("studentInfo", obj, _query_studentInfo(obj, obj.getDomainObject().getSecurityToken(), bundleId), outEvents, bundleId);
        __initialize(new Tuple(), obj, outEvents, ops, obj.getDomainObject().getSecurityToken(),bundleId);
    }

    private Object __initialize(Tuple tuple, DomainObjectWrapper obj, Set<DomainEvent> evts, Set<EvaluableDomainOperation> ops, String securityToken, String bundleId) throws DomainDataHandlerException {
        return null;
    }

    protected ActionInvoke ruleApplies(EvaluableDomainSubscriptionRule rule, DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        if ("subscribe_relation_onCreated_portfolio".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_portfolio(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_portfolio", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_portfolio".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_portfolio", tuple);
            }
        }
        if ("subscribe_relation_onCreated_studentContainer".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_studentContainer(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_studentContainer", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_studentContainer".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_studentContainer", tuple);
            }
        }
        if ("subscribe_relation_onCreated_studentExams".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_studentExams(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_studentExams", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_studentExams".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_studentExams", tuple);
            }
        }
        if ("subscribe_relation_onCreated_studentInfo".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (_matches_studentInfo(payload, obj, bundleId)){
                Tuple tuple = new Tuple();
                tuple.put("created",payload);
                return new ActionInvoke("_process_onRelatedCreate_studentInfo", tuple);
            }
        }
        if ("subscribe_relation_onDeleted_studentInfo".equals(rule.getRule().getEngineName())) {
            DomainObjectWrapper payload = (DomainObjectWrapper) rule.getEvent().getPayload();
            if (true){
                Tuple tuple = new Tuple();
                tuple.put("deleted",payload);
                return new ActionInvoke("_process_onRelatedDelete_studentInfo", tuple);
            }
        }
        return null;
    }


    @Override
    public boolean isRelation(String key) {
        return false
              || "portfolio".equals(key)
              || "studentContainer".equals(key)
              || "studentExams".equals(key)
              || "studentInfo".equals(key)
        ;    
    }

    @Override
    public String getType() {
        return "smartcampus.services.esse3.StudentEntity";
    }

    @Override
    public boolean isStatic() {
        return !true;
    }

    private static Collection<String> dependencies = new java.util.HashSet<String>();
    static {
        dependencies.add("smartcampus.services.esse3.Portfolio");
        dependencies.add("smartcampus.services.esse3.StudentContainer");
        dependencies.add("smartcampus.services.esse3.StudentExams");
        dependencies.add("smartcampus.services.esse3.StudentInfo");
        dependencies.add("smartcampus.services.esse3.Portfolio");
        dependencies.add("smartcampus.services.esse3.Portfolio");
        dependencies.add("smartcampus.services.esse3.StudentContainer");
        dependencies.add("smartcampus.services.esse3.StudentContainer");
        dependencies.add("smartcampus.services.esse3.StudentExams");
        dependencies.add("smartcampus.services.esse3.StudentExams");
        dependencies.add("smartcampus.services.esse3.StudentInfo");
        dependencies.add("smartcampus.services.esse3.StudentInfo");
    }

    public Collection<String> getDependencies() {
        return dependencies;
    }

    public Collection<DomainSubscriptionRule> getSubscriptions(DomainObjectWrapper obj, String bundleId) throws DomainDataHandlerException {
        List<DomainSubscriptionRule> rules = new ArrayList<DomainSubscriptionRule>();
        
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_portfolio");
            rule.setSourceId(null);
            rule.setSourceType("smartcampus.services.esse3.Portfolio");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_portfolio");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("portfolio", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("portfolio", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_portfolio " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.Portfolio");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_portfolio");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_studentContainer");
            rule.setSourceId(null);
            rule.setSourceType("smartcampus.services.esse3.StudentContainer");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_studentContainer");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("studentContainer", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("studentContainer", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_studentContainer " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.StudentContainer");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_studentContainer");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_studentExams");
            rule.setSourceId(null);
            rule.setSourceType("smartcampus.services.esse3.StudentExams");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_studentExams");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("studentExams", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("studentExams", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_studentExams " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.StudentExams");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_studentExams");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        {
            DomainSubscriptionRule 
            rule = new DomainSubscriptionRule();
            rule.setName("subscribe_relation_onCreated_studentInfo");
            rule.setSourceId(null);
            rule.setSourceType("smartcampus.services.esse3.StudentInfo");
            rule.setTargetId(obj.getId());
            rule.setTargetType(obj.getType());
            rule.setEngineName("subscribe_relation_onCreated_studentInfo");
            rule.setEventType(DOMAIN_OBJECT_EVENT_TYPE.CREATED .toString());
            rules.add(rule);
        }
        {
            DomainObjectWrapper ref = obj;
            if (getDomainObjectHandler().getRelationLinks("studentInfo", ref, bundleId)!=null) {
                for (DomainRelationTarget target : getDomainObjectHandler().getRelationLinks("studentInfo", ref, bundleId)) {
                    DomainSubscriptionRule rule1 = new DomainSubscriptionRule();
                    rule1.setName("subscribe_relation_onDeleted_studentInfo " + target.getTargetId());
                    rule1.setSourceId(target.getTargetId());
                    rule1.setSourceType("smartcampus.services.esse3.StudentInfo");
                    rule1.setTargetId(obj.getId());
                    rule1.setTargetType(obj.getType());
                    rule1.setEngineName("subscribe_relation_onDeleted_studentInfo");
                    rule1.setEventType(DOMAIN_OBJECT_EVENT_TYPE.DELETED .toString());
                    rules.add(rule1);
                }
            }
        }
        return rules;
    }

    
    public it.sayservice.platform.domain.model.interfaces.DomainTypeInterface getInterface() throws it.sayservice.platform.core.domain.common.exception.DomainDataHandlerException {
        return smartcampus.services.esse3 .StudentEntityInterface .getInstance();
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


