package ru.appline.sides;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SideService {
    private Map<String, IntervalDegree> sides = new HashMap<String, IntervalDegree>();

    public void addSide(String sideName, IntervalDegree interval) {
        sides.put(sideName, interval);
    }

    public void addSide(String sideName, String interval) {
        sides.put(sideName, new IntervalDegree(interval));
    }

    public Side whatSide(Degree degree){
        for (Map.Entry<String, IntervalDegree> entry : sides.entrySet()) {
            if(entry.getValue().getLeft() < entry.getValue().getRight()){
                if(degree.getDegree() <= entry.getValue().getRight() && degree.getDegree() >= entry.getValue().getLeft()){
                    return new Side(entry.getKey());
                }
            }
            if (entry.getValue().getLeft() > entry.getValue().getRight()){
                boolean fromLeft = degree.getDegree() >= entry.getValue().getLeft() && degree.getDegree() <= 360;
                boolean fromRight = degree.getDegree() <= entry.getValue().getRight() && degree.getDegree() >= 0;
                if (fromLeft || fromRight){
                    return new Side(entry.getKey());
                }
            }
        }
        throw new RuntimeException("Указанные градусы не попадают в известные части света");
    }

    public Map<String, IntervalDegree> getSides() {
        return sides;
    }
}