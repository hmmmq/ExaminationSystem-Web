package com.foodie.dto;

import java.util.Comparator;

public class UserTComparator implements Comparator<UserT> {

    @Override
    public  int compare(UserT o1, UserT o2) {
        if (o1.getUserType()== o2.getUserType())
            if (o1.getUserType()==1)
                if (o1.getStudent().getStuid()==o2.getStudent().getStuid())
                    return 1;
                else return -1;
            else
                if (o1.getTeacher().getTeaid()==o2.getTeacher().getTeaid())
                    return 1;
                else return -1;
        return -1;
    }
}
