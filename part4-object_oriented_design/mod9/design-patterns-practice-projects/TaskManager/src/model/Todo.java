package model;

import java.util.LinkedList;
import java.util.List;


public class Todo extends Doable {

    private String description;
    private List<Doable> subs;

//    private List<Todo> subTodos;
//    private List<Doable> subs;
//    private boolean complete;
//    private boolean subTodoComplete;
//    private boolean subTaskComplete;


    public Todo(String description) {
        super();
        this.description = description;
        subs = new LinkedList<>();
//        subTodos = new LinkedList<>();
//        complete = false;
//        subTodoComplete = false;
//        subTaskComplete = false;
    }

    // getters
    public List<Doable> getSubTasks() { return subs; }

//    public boolean getStatus() { return complete; }
//    public List<Todo> getSubTodos() { return subTodos; }

    public String getDescription() {
        return this.description;
    }

    @Override
    public void complete() {
        this.complete = getStatus();
    }

    @Override
    public void display(String indentSpace) {
        System.out.println(indentSpace + getDescription());
        for (Doable d: getSubTasks()) {
            d.display(indentSpace + indentSpace);
        }
    }

    /**
     *
     * @param d the item we want to add to our subs
     * @return true if we are able to add the item with no duplicates, else false
     */
    public boolean addDoable(Doable d) {
        if (!subs.contains(d)) {
            subs.add(d);
            return true;
        }
        return false;
    }

    /**
     *
     * @param d the item we want to remove from our subtodos
     * @return true if we are able to remove the item from our subtodos, else false
     */
    public boolean removeDoable(Doable d) {
        if (subs.contains(d)) {
            subs.remove(d);
            return true;
        }
        return false;
    }

    /**
     *
     * @return true if THIS Todo is complete
     */
    @Override
    public boolean getStatus() {
        return getSubTasks().stream().allMatch(d -> d.getStatus() == true);
    }

//    /**
//     *
//     * @return true if THIS subtask is complete
//     */
//    public boolean isThisTodoComplete() {
//        complete = subTodoComplete && subTaskComplete;
//        return complete;
//    }

//    /**
//     *
//      * @return true if the this subtodos are complete
//     */
//    public boolean todosComplete() {
//        boolean areTodosComplete = true;
//        for (Todo td : subTodos) {
//            if (!td.getStatus()) {
//                areTodosComplete = false;
//            }
//        }
//        subTodoComplete = areTodosComplete;
//        return subTodoComplete;
//    }
//
//    /**
//     *
//     * @return true if this subtasks are complete
//     */
//    public boolean subTaskComplete() {
//        boolean aresubTasksComplete = true;
//        for (Task t : subs) {
//            if (!t.getStatus()) {
//                aresubTasksComplete = false;
//            }
//        }
//        subTaskComplete = aresubTasksComplete;
//        return subTaskComplete;
//    }




    //    /**
//     *
//     * @param td the item we want to add to our subtodos
//     * @return true if we are able to add the item with no duplicates, else false
//     */
//    public boolean addDoable(Todo td) {
//        if (!subTodos.contains(td)) {
//            subTodos.add(td);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    /**
//     *
//     * @param td the item we want to remove from our subtodos
//     * @return true if we are able to remove the item from our subtodos, else false
//     */
//    public boolean removeDoable(Todo td) {
//        if (subTodos.contains(td)) {
//            subTodos.remove(td);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    /**
//     *
//     * @param t the task we want to add to our subtasks
//     * @return true if we are able to add the item to our subtasks, else false
//     */
//    public boolean addTask(Doable t) {
//        if (!subs.contains(t)) {
//            subs.add(t);
//            return true;
//        } else {
//            return false;
//        }
//    }

//    /**
//     *
//     * @param t the task we want to remove from our subtasks
//     * @return true if we are able to add the item to our subtasks, else false
//     */
//    public boolean removeTask(Doable t) {
//        if (subs.contains(t)) {
//            subs.remove(t);
//            return true;
//        } else {
//            return false;
//        }
//    }

}