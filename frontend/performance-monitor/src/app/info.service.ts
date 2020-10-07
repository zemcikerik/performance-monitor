import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BasicInfo, UsageInfo } from './models';

@Injectable({
  providedIn: 'root'
})
export class InfoService {

  private readonly basicInfoUrl = 'http://localhost:8080/info';
  private readonly usageInfoUrl = 'http://localhost:8080/usage';

  constructor(private httpClient: HttpClient) 
  { }

  getBasicInfo(): Observable<BasicInfo> {
    return this.httpClient.get<BasicInfo>(this.basicInfoUrl);
  }

  getUsageInfo(): Observable<UsageInfo[]> {
    return this.httpClient.get<UsageInfo[]>(this.usageInfoUrl);
  }

}
