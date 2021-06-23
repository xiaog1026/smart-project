import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiResponse } from 'app/model/api.response';
import { CodeValueMasterVO } from 'app/model/code.value.master.vo';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class CodeValueService {

  constructor(private http: HttpClient) { }

  registerCode(params: CodeValueMasterVO) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/code/registerCode`, params);
  }

  selectCodeBywordId(params: number) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/code/selectCodeBywordId`, params);
  }

  selectCodeByCodeId(params: number) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/code/selectCodeByCodeId`, params);
  }

  modifyCode(params: CodeValueMasterVO) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/code/modifyCode`, params);
  }

  deleteCode(params: CodeValueMasterVO) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/code/deleteCode`, params);
  }
}
