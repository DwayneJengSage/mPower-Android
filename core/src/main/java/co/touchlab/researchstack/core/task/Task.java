package co.touchlab.researchstack.core.task;

import android.content.Context;

import java.io.Serializable;

import co.touchlab.researchstack.core.result.TaskResult;
import co.touchlab.researchstack.core.step.Step;

public abstract class Task implements Serializable
{

    private String identifier;
    private String scheduleId;

    public Task()
    {
    }

    public Task(String identifier, String scheduleId)
    {
        this.identifier = identifier;
        this.scheduleId = scheduleId;
    }


    public String getIdentifier()
    {
        return identifier;
    }

    public String getScheduleId()
    {
        return scheduleId;
    }

    public abstract Step getStepAfterStep(Step step, TaskResult result);

    public abstract Step getStepBeforeStep(Step step, TaskResult result);

    public abstract Step getStepWithIdentifier(String identifier);

    public String getTitleForStep(Context context, Step step)
    {
        return step.getSceneTitle() != 0 ? context.getString(step.getSceneTitle()) : "";
    }

    public abstract TaskProgress getProgressOfCurrentStep(Step step, TaskResult result);

    /**
     * Throw exception if params are not valid
     */
    public abstract void validateParameters();

    public abstract int getNumberOfSteps();

    public static class TaskProgress
    {

        private int current;

        private int total;

        public TaskProgress(int current, int total)
        {
            this.current = current;
            this.total = total;
        }

        public int getCurrent()
        {
            return current;
        }

        public int getTotal()
        {
            return total;
        }
    }
}
