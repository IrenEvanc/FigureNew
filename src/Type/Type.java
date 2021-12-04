package Type;

    public enum Type {
        Triangle ("Треугольник"),
        Circle ("Окружность"),
        Rectangle ("Четырехугольник"),
        Polygon ("Многоугольник");

        private String title;

        Type(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "Фигура: " +  title;
        }
    }


