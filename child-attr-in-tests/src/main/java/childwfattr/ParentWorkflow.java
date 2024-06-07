package childwfattr;

import io.temporal.common.SearchAttributeKey;
import io.temporal.common.SearchAttributes;
import io.temporal.workflow.ChildWorkflowOptions;
import io.temporal.workflow.Workflow;
import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface ParentWorkflow {

    @WorkflowMethod
    void doParentWork();

    class Impl implements ParentWorkflow {

        private static final String SEARCH_ATTR = "CustomSearchAttribute";

        @Override
        public void doParentWork() {
            System.out.println("doParentWorkStart");
            var childStub = Workflow.newChildWorkflowStub(
                    ChildWorkflow.class,
                    ChildWorkflowOptions.newBuilder()
                            .setTypedSearchAttributes(SearchAttributes.newBuilder()
                                    .set(SearchAttributeKey.forText(SEARCH_ATTR), "abc")
                                    .build()
                            )
                            .build()
            );
            childStub.doChildWork();
            System.out.println("doParentWorkEnd");
        }
    }
}
