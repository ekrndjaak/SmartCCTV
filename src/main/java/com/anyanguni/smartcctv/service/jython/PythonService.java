package com.anyanguni.smartcctv.service.jython;

import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

@Service
public class PythonService {
    public String executePythonScript(String name) {
        try (PythonInterpreter pyInterp = new PythonInterpreter()) {
            pyInterp.execfile("src/main/resources/jython/test.py"); // Python 스크립트 경로
            return pyInterp.eval("greet('" + name + "')").toString(); // greet 함수 호출
        }
    }
}
