import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArquivoService {

  constructor(private http: HttpClient) { }

  salvar(data: File): Observable<any> {
    let formData = new FormData();
    formData.append('arquivo', data, data.name);

    return this.http.post<any>
      ("http://200.98.142.28/:8080/scp/public/arquivo",formData);
  }
   

}
