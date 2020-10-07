import { Component, OnInit, OnDestroy } from '@angular/core';

import { interval, Subscription } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { InfoService } from '../info.service';
import { BasicInfo, UsageInfo } from '../models';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  public chartData: any[];

  public colorScheme = {
    domain: ['#5AA454', '#E44D25', '#CFC0BB', '#7aa3e5', '#a8385d', '#aae3f5']
  };

  public basicInfo: BasicInfo;
  public usageInfo: UsageInfo[];
  private subscription: Subscription;

  constructor(private infoService: InfoService) 
  { }

  ngOnInit(): void {
    this.infoService.getBasicInfo()
      .subscribe(info => this.basicInfo = info, err => console.error(err));

    this.subscription = interval(1000).pipe(
      flatMap(() => this.infoService.getUsageInfo())
    ).subscribe(info => {
      this.usageInfo = info;
      this.updateChartData();
    }, err => console.error(err));
  }

  updateChartData(): void {
    this.chartData = [
      {
        name: "CPU Usage",
        series: this.usageInfo.map(info => ({
          name: info.unixTimestamp,
          value: info.cpuUsage
        }))
      }
    ];
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

}
