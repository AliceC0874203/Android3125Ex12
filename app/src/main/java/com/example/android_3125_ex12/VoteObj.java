package com.example.android_3125_ex12;

import java.util.ArrayList;

public class VoteObj {
    String name;
    String id;
    Candidate candidate;
    boolean isAccept;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public boolean isAccept() {
        return isAccept;
    }

    public VoteObj(String name, String id, Candidate candidate, boolean isAccept) {
        this.name = name;
        this.id = id;
        this.candidate = candidate;
        this.isAccept = isAccept;
    }

    public static ArrayList<VoteObj> voteObjArrayList = new ArrayList<>();

    public static int getVoteNumberByCandidate(Candidate candidate) {
        return (int) voteObjArrayList.stream().filter(voteObj -> candidate.equals(voteObj.candidate)).count();
    }

    public static Object[] getVoteObjArrayListByCandidate(Candidate candidate) {
        return voteObjArrayList.stream().filter(voteObj -> candidate.equals(voteObj.candidate)).toArray();
    }

    @Override
    public String toString() {
        return "VoteObj{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", candidate=" + candidate +
                ", isAccept=" + isAccept +
                '}';
    }
}

enum Candidate {
    candidate1,
    candidate2,
    candidate3
}