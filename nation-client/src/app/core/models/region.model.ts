import { Continent } from './continent.model';

export interface Region {
  regionId: number;
  name: string;
  continent: Continent;
}
