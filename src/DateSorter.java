import java.time.LocalDate;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 * Implement in single class.
 */
public class DateSorter {
    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
     * would sort to
     * (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        // your solution here
        // Creating the necessary lists
        List<LocalDate> dateWithR = new ArrayList();
        List<LocalDate> dateWithoutR = new ArrayList();
        List<LocalDate> resultList = new ArrayList();
        // Cycle for sort list on 2 lists with 'r' months and no 'r' months
        for (LocalDate date : unsortedDates) {
            if(date.getMonth().name().toLowerCase().contains("r")) {
                dateWithR.add(date);
            } else {
                dateWithoutR.add(date);
            }
        }
        // ascending sort
        Collections.sort(dateWithR);
        // descending sort
        Collections.sort(dateWithoutR, Collections.reverseOrder());
        // Unification of 2 lists
        dateWithR.addAll(dateWithoutR);
        // Filling result list
        resultList.addAll(dateWithR);
        return resultList;
    }

    public static void main(String[] args) {
        List<LocalDate> unsortedDates = new ArrayList<>();
        List<LocalDate> unsortedDates2 = new ArrayList<>();
        // test case 1
        // start values: (2005-07-01, 2005-01-02, 2005-01-01, 2005-05-03)
        unsortedDates.add(LocalDate.of(2005, 07, 01));
        unsortedDates.add(LocalDate.of(2005, 01, 02));
        unsortedDates.add(LocalDate.of(2005, 01, 01));
        unsortedDates.add(LocalDate.of(2005, 05, 03));
        // expected (2005-01-01, 2005-01-02, 2005-07-01, 2005-05-03)

        // test case 2
        // start values: (2005-08-11, 2005-11-22, 2005-01-05, 2005-05-08)
        unsortedDates2.add(LocalDate.of(2005, 8, 11));
        unsortedDates2.add(LocalDate.of(2005, 11, 12));
        unsortedDates2.add(LocalDate.of(2005, 1, 5));
        unsortedDates2.add(LocalDate.of(2005, 5, 8));
        // expected (2005-01-05, 2005-11-12, 2005-08-11, 2005-05-08)
        // target list creation
        List<LocalDate> sortedDates = new ArrayList<>();
        List<LocalDate> sortedDates2 = new ArrayList<>();

        DateSorter dateSorter = new DateSorter();
        // sorts and add sorted lists to new list
        sortedDates.addAll(dateSorter.sortDates(unsortedDates));
        sortedDates2.addAll(dateSorter.sortDates(unsortedDates2));
        // result output
        System.out.println(sortedDates);
        System.out.println(sortedDates2);
    }
}