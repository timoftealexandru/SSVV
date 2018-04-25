/**
 * Created by Nicu on 24/04/2018.
 */
import controller.MemberController;
import model.Entry;
import model.Member;
import repository.MemberRepository;

import java.util.List;

public class MemberControllerTest {
    @org.junit.Test
    public void addMember() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        Member m1 = new Member("Darius","1", 10, 20);
        c.addMember(m1);
        List<Member> m = c.getMembers();
        assert(m.get(m.size()-1) == m1);
        Member m2 = new Member("Andrei","2", 10, 20);
        c.addMember(m2);
        assert(m.get(m.size()-1) == m2);
    }

    @org.junit.Test
    public void addEntry() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        Entry e = new Entry("cost",10,4);
        c.addEntry(e);
        List<Entry> l = c.allEntries();
        assert (l.get(l.size()-1) == e);
    }

    @org.junit.Test
    public void testFailValidateID() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateID("abc");
        assert(!isValid);
    }

    @org.junit.Test
    public void testSuccessValidateID() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateID("25");
        assert(isValid);
    }

    @org.junit.Test
    public void testFailValidateValue() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateValue("abc");
        assert(!isValid);
    }

    @org.junit.Test
    public void testSuccessValidateValue() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateValue("25");
        assert(isValid);
    }


    @org.junit.Test
    public void testFailValidateType() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateType("");
        assert(!isValid);
    }

    @org.junit.Test
    public void testSuccessValidateType() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        boolean isValid = c.validateType("entryType");
        assert(isValid);
    }

    @org.junit.Test
    public void testAddEntryInvalidType() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);

        int added = c.addEntry("", "25", "1");
        assert(added == 0);
    }

    @org.junit.Test
    public void testAddEntryInvalidValue() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int added = c.addEntry("type", "value", "25");
        assert(added == 0);
    }

    @org.junit.Test
    public void testAddEntryInvalidID() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int added = c.addEntry("type", "25", "id");
        assert(added == 0);
    }

    @org.junit.Test
    public void testAddEntryValid() throws Exception {
        MemberRepository r = new MemberRepository();
        MemberController c = new MemberController(r);
        int added = c.addEntry("type", "25", "35");
        assert(added == 1);
    }

}
