package childwfattr;

import java.time.Duration;

import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ChildWorkflow {

    @WorkflowMethod
    void doChildWork();

    class Impl implements ChildWorkflow {

        @Override
        public void doChildWork() {
            System.out.println("doChildWorkStart");
            Workflow.sleep(Duration.ofSeconds(1));
            System.out.println("doChildWorkEnd");
        }
    }
}
