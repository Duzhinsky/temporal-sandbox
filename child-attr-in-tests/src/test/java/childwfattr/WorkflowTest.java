package childwfattr;

import io.temporal.testing.TestWorkflowExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

public class WorkflowTest {

    @RegisterExtension
    public static final TestWorkflowExtension workflowExtension = TestWorkflowExtension.newBuilder()
            .setWorkflowTypes(ParentWorkflow.Impl.class, ChildWorkflow.Impl.class)
            .build();

    @Test
    void test(ParentWorkflow parentWorkflow) {
        parentWorkflow.doParentWork();
    }
}
