package input;

public final class Filter {
    private FilterOption contains;
    private SortMovies sort;

    public FilterOption getContains() {
        return contains;
    }

    public void setContains(final FilterOption contains) {
        this.contains = contains;
    }

    public SortMovies getSort() {
        return sort;
    }

    public void setSort(final SortMovies sort) {
        this.sort = sort;
    }


    public final class SortMovies {
        private String rating;
        private String duration;

        public String getRating() {
            return rating;
        }

        public void setRating(final String rating) {
            this.rating = rating;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(final String duration) {
            this.duration = duration;
        }


    }
}
