public class WordData {
    public int max_word_length = 0;
    public int count_max = 1;
    private int point_count;

    public WordData(int point_count) {
        this.point_count = point_count;
    }

    public int GetPointCount() {
        return point_count;
    }
}
