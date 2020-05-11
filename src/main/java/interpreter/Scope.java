package interpreter;

import symboltable.Type;

import java.util.HashMap;

public class Scope {
  Scope prev_scope;

  // Name: value
  HashMap<String, Value> scope;

  public Scope() {
    scope = new HashMap<>();
  }

  public Scope(Scope prev_scope) {
    scope = new HashMap<>();
    this.prev_scope = prev_scope;
  }

  Value resolve_local(String name) {
    // TODO: return a copy?
    return scope.get(name);
  }

  // recursively find Symbol's value
  public Value resolve(String name) {
    Value result = scope.get(name);
    if (result == null && prev_scope != null) {
      result = prev_scope.resolve(name);
    }
    // TODO? check if is null
    return result;
  }

  public void insert(String name, Value value) {
    scope.put(name, value);
  }

  // return: if update success.
  // TODO: update must be successful?
  public Boolean update(String name, Value value) {
    if(scope.containsKey(name)) {
      scope.put(name, value);
    } else {
      prev_scope.update(name, value);
    }
    return true;
  }

  @Override
  public String toString() {
    return String.valueOf(scope);
  }
}