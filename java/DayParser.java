public class DayParser {

    private static final Integer MAX_FETCH_DAYS;
    private static final Integer DEFAULT_DAYS;
    private static final Integer MIN_DAYS;
    private static final String REGEX;

    static {
        MAX_FETCH_DAYS = 30;
        DEFAULT_DAYS = 7;
        MIN_DAYS = Math.min(DEFAULT_DAYS, MAX_FETCH_DAYS);
        REGEX = String.format("^[+]?\\d{1,%s}+$", MAX_FETCH_DAYS.toString().length());
    }

    public static int getDays(final String input) {
        final TimeFilter filter = TimeFilter.getFilter(input);
        if (filter != TimeFilter.CUSTOM)
            return Math.min(filter.getDayValue(), MAX_FETCH_DAYS);
        if (!input.matches(REGEX))
            return MIN_DAYS;
        final int days = Integer.parseInt(input);
        if (days <= 0)
            return MIN_DAYS;
        return Math.min(days, MAX_FETCH_DAYS);
    }

    public static Parsed get(final String[] args) {
        final int days;

        if (args.length >= 1) {
            String day = args[args.length == 1 ? 0 : 1];
            days = getDays(day);
        } else {
            days = MIN_DAYS;
        }
        return new Parsed(days);
    }

    public static class Parsed {

        private final int days;

        public Parsed(final int days) {
            this.days = days;
        }

        public int getDays() {
            return days;
        }
    }

}
