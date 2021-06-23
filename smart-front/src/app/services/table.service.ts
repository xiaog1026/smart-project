import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ApiResponse } from 'app/model/api.response';
import { TableMasterVO } from 'app/model/table.master.vo';
import { environment } from 'environments/environment';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class TableService {

  constructor(private http: HttpClient) { }

  searchAllTables() : Observable<ApiResponse> {
    return this.http.get<ApiResponse>(`${environment.baseUrl}/table/searchAllTables`);
  }

  searchTables(params: any) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/table/searchTables`, params);
  }

  upload(data) {
    return this.http.post(`${environment.baseUrl}/table/upload`, data);
  }

  registerTable(params: TableMasterVO) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/table/registerTable`, params);
  }

  searchTable(params: number) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/table/searchTable`, params);
  }

  modifyTable(params: TableMasterVO) : Observable<ApiResponse> {
    return this.http.post<ApiResponse>(`${environment.baseUrl}/table/modifyTable`, params);
  }

}
