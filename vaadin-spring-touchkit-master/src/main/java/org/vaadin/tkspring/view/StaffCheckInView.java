package org.vaadin.tkspring.view;

import javax.annotation.PostConstruct;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LMarker;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.LTileLayer;
import org.vaadin.addon.leaflet.shared.Point;
import org.vaadin.viritin.layouts.MVerticalLayout;

import com.vaadin.addon.touchkit.extensions.Geolocator;
import com.vaadin.addon.touchkit.extensions.PositionCallback;
import com.vaadin.addon.touchkit.gwt.client.vcom.Position;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;

@SpringComponent
@UIScope
public class StaffCheckInView extends NavigationView implements PositionCallback{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6265304953321565393L;
	
	LMap map = new LMap();
	LTileLayer osmTiles = new LOpenStreetMapLayer();
	LMarker marker = new LMarker(0,0);

	@PostConstruct
	public void init() {

		Button button = new Button("Click to get Location");
		button.addClickListener(e->getLocation());
		map.addLayer(osmTiles);	
		marker.setPoint(new Point(25.05568, 121.58439));
		marker.setPopup("Office");
		map.addLayer(marker);
		map.setCenter(25.05568, 121.58439);
		map.setZoomLevel(15);
		map.setHeight("300px");
		map.setHeight("300px");
		setContent(new MVerticalLayout(map,button));
	}


	private void getLocation() {
		Geolocator.detect(StaffCheckInView.this);
	}


	@Override
	public void onSuccess(Position position) {
		map.removeLayer(marker);
		LMarker marker1 = new LMarker(position.getLatitude(),position.getLongitude());
		map.addLayer(osmTiles);	
		marker.setPopup("Home");
		map.addLayer(marker1);
		map.setCenter(position.getLatitude(),position.getLongitude());
		map.setZoomLevel(15);
		map.setImmediate(true);
	}


	@Override
	public void onFailure(int errorCode) {
		
		
	}


}
