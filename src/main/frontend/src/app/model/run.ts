export class Run {
  courseId: number;
  order: number;
  dog: string;
  guide: string;
  faults: number = 0;
  refusals: number = 0;
  time: number;
  category: number;
  position: number;
  qualification: string;

  constructor(courseId: number, order: number, dog: string,
              guide: string, faults: number, refusals: number,
              time: number, category: number, position: number,
              qualification: string) {
    this.courseId = courseId;
    this.order = order;
    this.dog = dog;
    this.guide = guide;
    this.faults = faults;
    this.refusals = refusals;
    this.time = time;
    this.category = category;
    this.position = position;
    this.qualification = qualification;
  }
}
