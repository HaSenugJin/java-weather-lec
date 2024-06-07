package dto;

public class Request {

    public static class DTO {
        private String category;
        private String obsrValue;


        public String getCategory() {
            return category;
        }

        public String getObsrValue() {
            return obsrValue;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public void setObsrValue(String obsrValue) {
            this.obsrValue = obsrValue;
        }

        @Override
        public String toString() {
            return "DTO{" +
                    "category='" + category + '\'' +
                    ", obsrValue='" + obsrValue + '\'' +
                    '}';
        }
    }
}
