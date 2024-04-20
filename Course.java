package Student;

import java.util.HashMap;
import java.util.Map;

public class Course {
    private String name;
    private Map<String, Integer> requirements;

    public Course(String name, int mathRequirement, int physicsRequirement, int scienceRequirement) {
        this.name = name;
        this.requirements = new HashMap<>();
        requirements.put("math", mathRequirement);
        requirements.put("physics", physicsRequirement);
        requirements.put("science", scienceRequirement);
    }

    public boolean isEligible(int mathScore, int physicsScore, int scienceScore) {
        return mathScore >= requirements.get("math") &&
                physicsScore >= requirements.get("physics") &&
                scienceScore >= requirements.get("science");
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getRequirements() {
        return requirements;
    }
}
