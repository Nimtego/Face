package model.shapes;

import java.util.HashMap;
import java.util.Map;

import static model.shapes.PartFace.*;

/**
 * Created by myasnikov
 * on 05.10.2017.
 */
public class Form  {
    private Map<PartFace, Shape> faceMap;

    private Form() {
        faceMap = new HashMap<>();
    }
    public void setFaceMap(Map<PartFace, Shape> faceMap) {
        this.faceMap = faceMap;
    }

    public static FormBuilder formBuilder() {
        return new Form().new FormBuilder();
    }


/*    private char[][] toCharArray() {
        int columns = 0;
        int rows = 0;
        for (Shape shape : faceMap.values()) {
            char[][] tmp = shape.toCharArray();
            columns = tmp.length > columns ?  tmp.length : columns;
            rows = tmp[0].length > rows ? tmp[0].length : rows;
        }
        char[][] form = new char[columns][rows];
        char[][] person = faceMap.get(PERSON).toCharArray();
        for (int i = 0; i < form.length; i++) {
            for (int j = 0; j < form[i].length; j++) {

            }
        }

    }*/

    //Builder iner
    public class FormBuilder {

        private FormBuilder() {
        }

        public FormBuilder person(Shape shape) {
            Form.this.faceMap.put(PERSON, shape);
            return this;
        }
        public FormBuilder hat(Shape shape) {
            Form.this.faceMap.put(HAT, shape);
            return this;
        }

        public FormBuilder ears(Shape shape) {
            Form.this.faceMap.put(EARS, shape);
            return this;
        }

        public FormBuilder nose(Shape shape) {
            Form.this.faceMap.put(NOSE, shape);
            return this;
        }
        public FormBuilder eyes(Shape shape) {
            Form.this.faceMap.put(EYES, shape);
            return this;
        }
        public FormBuilder mouth(Shape shape) {
            Form.this.faceMap.put(MOUTH, shape);
            return this;
        }
        public Form build() {
            Form form = new Form();
            form.faceMap = Form.this.faceMap;
            return form;
        }
    }
}
