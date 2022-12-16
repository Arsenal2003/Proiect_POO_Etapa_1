public class Filter {
    private FilterOption contains;
    private SortMovies sort;

    public FilterOption getContains() {
        return contains;
    }

    public void setContains(FilterOption contains) {
        this.contains = contains;
    }

    public SortMovies getSort() {
        return sort;
    }

    public void setSort(SortMovies sort) {
        this.sort = sort;
    }

    public class SortMovies{
        private String rating;
        private String duration;

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }
    }
}
