package model;

public enum Categories {
	
	ABANDONED_VEHICLE {
		@Override
		public String description() {
			return "Abandoned Vehicle";
		}
	}, DOG_FOULING {
		@Override
		public String description() {
			return "Dog Fouling";
		}
	}, DOWN_LAMP_POST {
		@Override
		public String description() {
			return "Downed Lamp-Post";
		}
	}, DOWN_TREE {
		@Override
		public String description() {
			return "Downed Tree";
		}
	}, FLY_TIPPING {
		@Override
		public String description() {
			return "Flytipping";
		}
	}, FLY_POSTING {
		@Override
		public String description() {
			return "Flyposting";
		}
	}, GRAFFITI {
		@Override
		public String description() {
			return "Graffiti";
		}
	}, POTHOLE {
		@Override
		public String description() {
			return "Pothole";
		}
	}, PUBLIC_TOILETS {
		@Override
		public String description() {
			return "Public Toilets";
		}
	}, ROAD_CONDITIONS {
		@Override
		public String description() {
			return "Dangerous Road Conditions";
		}
	},STREET_CLEANING {
		@Override
		public String description() {
			return "Street Cleaning";
		}
	}, STREET_LIGHTING {
		@Override
		public String description() {
			return "Street Lighting";
		}
	}, TRASH {
		@Override
		public String description() {
			return "Trash/Bins";
		}
	}, OTHER {
		@Override
		public String description() {
			return "Other";
		}
	};
	
	public abstract String description();

}
