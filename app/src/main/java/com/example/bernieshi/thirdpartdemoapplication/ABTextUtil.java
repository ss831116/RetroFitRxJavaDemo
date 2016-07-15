package com.example.bernieshi.thirdpartdemoapplication;

import java.util.List;

import rx.subjects.Subject;

/**
 * Created by bernie.shi on 2016/7/15.
 */
public class ABTextUtil {
    public static boolean isEmpty(List<Subject> subjectList) {
        boolean isEmpty = subjectList.isEmpty() ? true : false;
        return isEmpty;
    }
}
