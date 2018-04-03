import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.*;
import model.Entry;
import model.Member;
import org.junit.rules.ExpectedException;
import repository.MemberRepository;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * test for adding member
     */
    public void testAddMember() {
        Member member = new Member("Nicu", "1", 100, 150);
        MemberRepository repo = new MemberRepository();
        repo.addMember(member);
        List<Member> members = repo.getAllMembers();
        Member last = members.get(members.size() -1);
        assert (member==last);
    }

    /**
     * test for adding entry
     */
    public void testAddEntry() {
        Entry entry = new Entry("Entry1",  100, 1);
        MemberRepository repo = new MemberRepository();
        repo.addEntry(entry);
        List<Entry> entries = repo.getAllEntries();
        Entry last = entries.get(entries.size() -1);
        assert (entry == last);
    }

    public void testEntryType() {
        Entry entry = new Entry("Entry2",  100, 2);
        assert (entry.getType() == "Entry2");
    }

    public void testEntryValue() {
        Entry entry = new Entry("Entry3",  100, 3);
        assert (entry.getValue() == 100);
    }

    public void testEntryId() {
        Entry entry = new Entry("Entry4",  100, 4);
        assert (entry.getIdMember() == 4);
    }

    public void testEntryEmptyType() {
        Entry entry = new Entry("",  100, 4);
        assert (entry.getType() == "");
    }

    public void testAddNonUniqueMember(){

        Member member = new Member("Nicu", "1", 100, 150);
        MemberRepository repo = new MemberRepository();
        try {
            repo.addMember(member);
            repo.addMember(member);
            fail("Member exist!");
        } catch (Error e) {
            assertEquals(e.getMessage(), "Member exist!");
        }


    }

    public void testMemberName() {
        Member member = new Member("Nicu", "1", 100, 150);
        assert (member.getName() == "Nicu");
    }

    public void testMemberMonthlyValue() {
        Member member = new Member("Nicu", "2", 100, 150);
        assert (member.getMonthlyValue() == 100);
    }

    public void testMemberContributedValue() {
        Member member = new Member("Nicu", "2", 100, 150);
        assert (member.getContributedValue() == 150);
    }

}
