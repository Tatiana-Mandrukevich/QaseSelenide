package objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCase {

    private String title;
    private String status;
    private String description;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String milestone;
    private String behavior;
    private String automationStatus;
    private String preConditions;
    private String postConditions;
    private String stepsStepAction;
    private String stepsData;
    private String stepsExpectedResult;
}