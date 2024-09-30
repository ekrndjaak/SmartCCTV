package com.anyanguni.smartcctv.controller.python;

import com.anyanguni.smartcctv.service.jython.PythonService;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PythonController {

    @GetMapping("/predict")
    public String predict(@RequestParam int input) {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            // 모델 파일을 로드
            pyInterp.exec("from model import SimpleModel");
            pyInterp.exec("model = SimpleModel()");

            // 예측 수행
            pyInterp.set("input_data", new int[]{input});
            pyInterp.exec("result = model.predict(input_data)");

            // 결과 가져오기
            int[] result = pyInterp.get("result", int[].class);
            return "Prediction: " + result[0];
        } catch (Exception e) {
            return "Error executing Python script: " + e.getMessage();
        }
    }
}
