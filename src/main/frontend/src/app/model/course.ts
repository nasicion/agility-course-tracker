import {Run} from './run';

export  class Course {
  id : number = undefined;
  judge : string ;
  date : Date;
  lenght : number;
  standardCourseTime : number;
  maximiumCourseTime : number;
  speed : number;
  runs : Run[];

  constructor(){}
}
