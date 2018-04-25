/**
 * Created by Nicu on 25/04/2018.
 */

import controller.MemberController;
import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.List;

public class BigBangIntegration {
    MemberRepository repo;
    MemberController ctrl;

    @org.junit.Before
    public void setup() {
        repo = new MemberRepository();
        ctrl = new MemberController(repo);
    }

    @org.junit.Test
    public void addMember() {
        Member m1 = new Member("Darius","1", 10, 20);
        ctrl.addMember(m1);
        List<Member> lst = ctrl.getMembers();
        assert(lst.get(lst.size()-1) == m1);
        Member m2 = new Member("Andrei","4", 10, 20);
        ctrl.addMember(m2);
        List<Member> lst2 = ctrl.getMembers();
        assert(lst2.get(lst.size()-1) == m2);
    }

    @org.junit.Test
    public void addEntry() {
        Entry e =  new Entry("cost",10,4);
        ctrl.addEntry(e);
        List<Entry> l = ctrl.allEntries();
        assert (l.get(l.size()-1) == e);
    }

    @org.junit.Test
    public void getEntries() {
        ctrl.addEntry(new Entry("type1",25,4));
        ctrl.addEntry(new Entry("type2",35,4));

        Integer size = ctrl.getEntriesForMember(4).size();
        assert (size == 3 || size == 2);
    }

    @org.junit.Test
    public void runBigBangIntegration() {
        addMember();
        addEntry();
        getEntries();
    }

}