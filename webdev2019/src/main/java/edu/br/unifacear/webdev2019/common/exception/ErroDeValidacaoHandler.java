package edu.br.unifacear.webdev2019.common.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;




 
@RestControllerAdvice  //Interceptador de Exception
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	
	//Padrão de interceptador
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)	//Resposta do servidor 
	@ExceptionHandler(MethodArgumentNotValidException.class) // Qual será a Exception que chamará este metodo
	public List<MensagemErro> handle(MethodArgumentNotValidException ex) { // Recebe o mesmo Objeto da exception
		List<MensagemErro> listMsg = new ArrayList<>();
		
		// pegar resultado das validações, pegar os erros de campo
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors(); 
		
		fieldErrors.forEach(e -> {
			String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale()); //intercionalizada
			MensagemErro erro = new MensagemErro(e.getField(), new BusinessException(BusinessExceptionCode.ERR501));
			listMsg.add(erro);
		});
		return listMsg;
	}
	
}
//